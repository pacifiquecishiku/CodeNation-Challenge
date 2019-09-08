
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import static javax.management.Query.value;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pacifique
 */
public class Controller {

    private URL url;
    private HttpURLConnection http_url_connection;

    public Controller() throws MalformedURLException, IOException, NoSuchAlgorithmException {
        url = new URL("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=...");
        http_url_connection = (HttpURLConnection) url.openConnection();

        InputStream input = http_url_connection.getInputStream();

        JSONObject json = new JSONObject(lerStream(input));

        System.out.println(json.toString());

        System.out.println(decifrar("i kwuxcbmz xzwoziu lwma epib gwc bmtt qb bw lw, vwb epib gwc eivb qb bw lw. cvsvwev"));
        
        System.out.println(resumoSHA1(decifrar("i kwuxcbmz xzwoziu lwma epib gwc bmtt qb bw lw, vwb epib gwc eivb qb bw lw. cvsvwev")));
    }

    private String lerStream(InputStream input) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(input);
        BufferedReader inputbuffer = new BufferedReader(inputReader);

        return inputbuffer.readLine();
    }

    private String decifrar(String cifrado) {
        ArrayList<String> alphabet = new ArrayList<>();
        String decifrado = "";
        String caractere = "";
        int indice = 0;

        alphabet.add("");
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        alphabet.add("g");
        alphabet.add("h");
        alphabet.add("i");
        alphabet.add("j");
        alphabet.add("k");
        alphabet.add("l");
        alphabet.add("m");
        alphabet.add("n");
        alphabet.add("o");
        alphabet.add("p");
        alphabet.add("q");
        alphabet.add("r");
        alphabet.add("s");
        alphabet.add("t");
        alphabet.add("u");
        alphabet.add("v");
        alphabet.add("w");
        alphabet.add("x");
        alphabet.add("y");
        alphabet.add("z");

        System.out.println("i kwuxcbmz xzwoziu lwma epib gwc bmtt qb bw lw, vwb epib gwc eivb qb bw lw. cvsvwev");
        for (int i = 0; i < cifrado.length(); i++) {
            caractere = Character.toString(cifrado.charAt(i)); //Recuperando o caratere cifrado na posição i

            if (alphabet.contains(caractere)) {
                indice = alphabet.indexOf(caractere);
                for (int j = 8; j >= 1; j--) {
                    if (indice == 0) {
                        indice = 26;
                    }
                    indice = indice - 1;
                }
                caractere = alphabet.get(indice);
            }
            decifrado = decifrado + caractere;
        }

        return decifrado;
    }

    private String resumoSHA1(String texto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String resumo = "";
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
	digest.reset();
	digest.update(texto.getBytes("utf8"));
	resumo = String.format("%040x", new BigInteger(1, digest.digest()));

        return resumo;
    }
}
