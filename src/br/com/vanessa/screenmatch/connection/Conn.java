package br.com.vanessa.screenmatch.connection;

import br.com.vanessa.screenmatch.models.Title;
import br.com.vanessa.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.ConnectException;

public class Conn {
    private final String address = "";

    public String searchTitle(String title){
        var address = "https://www.omdbapi.com/?t=" + title.replace(" ", "+") + "&apikey=41218775";
        try{
            //do the request
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            //receive a response
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //translate to json
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create(); //naming standard
            String json = response.body();
            TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
            Title myTitle = new Title(myTitleOmdb);
            return gson.toJson(myTitle);
        } catch (ConnectException e){
            System.out.println("Erro de conexão " + e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void writeDataToFile(String filme){
        System.out.println("filme array " + filme);
        try{
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create(); //naming standard
            FileWriter write = new FileWriter("listaFilmes.json");
            write.write(gson.toJson(write));
            write.close();
            System.out.println("Arquivo gerado com sucesso");
        } catch (IOException e){
            System.out.println("Erro ao gerar arquivo " + e.getMessage());
        }  catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
