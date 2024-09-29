package com.lehua.transaction_generator;

import com.google.gson.Gson;
import com.lehua.common.model.Concurrency;
import com.lehua.common.model.TransactionDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TransactionGeneratorApplication {

    private final static String BASE_URL = "http://transaction-api:8080/api/transactions";

    public static void main(String[] args) throws InterruptedException, IOException {
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        while (true) {
            String jsonTransaction = gson.toJson(generateTransaction());

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonTransaction))
                    .build();

            Thread.sleep(5000);

            System.out.println("Sending transaction...");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
        }

    }

    private static TransactionDto generateTransaction() {
        return TransactionDto.builder()
                .id("p6SIXrRT55gpKYwkFJEK103MvlnTeRCZ")
                .senderAccountId("299275084766")
                .receiverAccountId("013646505757")
                .amount(4999.01)
                .concurrency(Concurrency.EUR)
                .location("Italy, Milan")
                .build();
    }

}
