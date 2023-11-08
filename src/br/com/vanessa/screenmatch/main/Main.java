package br.com.vanessa.screenmatch.main;

import br.com.vanessa.screenmatch.connection.Conn;
import br.com.vanessa.screenmatch.exception.ExceededLength;
import br.com.vanessa.screenmatch.models.Title;
import br.com.vanessa.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Conn conn = new Conn();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create(); //naming standard

        /*try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o nome do filme que deseja buscar: " );
            var search = sc.next();
            var address = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=41218775";
            //do the request
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            //receive a response
            HttpResponse<String> response = client
                    .send(request,HttpResponse.BodyHandlers.ofString());
            //Gson gson = new Gson();
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create(); //exerce um padrão de nomeclatura
            String json = response.body();
            System.out.println("json " + json);

            Title myTitle = gson.fromJson(json, Title.class);

            TitleOmdb titleOmbd = gson.fromJson(json, TitleOmdb.class);
            Title meuTitulo = new Title(titleOmbd);
            System.out.println("conversao gson: " + titleOmbd);
            System.out.println("Class title " + meuTitulo);
        } catch(ExceededLength e){
            System.out.println(e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("Erro " + e.getMessage());
        }catch (Exception e){
            System.out.println("Deu BO " + e.getMessage());
        }*/
        int resp;
        do{
            System.out.println("==============Menu de opções======================");
            System.out.println("1 - Procurar filme");
            System.out.println("2 - Gravar filmes em um arquivo");
            System.out.println("0 - Sair");
            resp = sc.nextInt();
            if(resp == 1){
                System.out.println("Digite o nome do filme que deseja procurar: ");
                String title = sc.next();

                System.out.println(conn.searchTitle(title));
            } else if(resp == 2){
                String title;
                int op;
                List<Title> document = new ArrayList<>();
                do{
                    System.out.println("1 - Digitar titulo ");
                    System.out.println("0 - Salvar e sair");
                    op = sc.nextInt();
                    if(op == 1){
                        System.out.println("titulo: ");
                        title = sc.next();
                        String json = conn.searchTitle(title);
                        TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
                        Title myTitle = new Title(myTitleOmdb);
                        document.add(myTitle);
                        System.out.println("Array " + document);
                    } else {
                        FileWriter archive = new FileWriter("filmes.json");
                        archive.write(gson.toJson(document));
                        archive.close();
                        System.out.println("o arquivo foi salvo om sucesso!");

                    }
                } while (op != 0);
                break;
            } else {
                System.out.println("Opção inválida");
            }
        } while (resp != 0);
        String test = conn.searchTitle("matrix");
        System.out.println("teste " + test);
        conn.writeDataToFile(test);

    }
}
