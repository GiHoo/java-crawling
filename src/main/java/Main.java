import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String url = br.readLine();
        Document doc = Jsoup.connect(url).get();

        System.out.println(doc.title());
        System.out.println("문제 설명: " + doc.body().getElementById("problem_description").text());

        System.out.println();

        System.out.println("입력: " + doc.body().getElementById("problem_input").text());
        System.out.println("출력: " + doc.body().getElementById("problem_output").text());

        System.out.println();

        System.out.println("예제 입력 1:");
        System.out.println(doc.body().getElementById("sample-input-1").text());

        System.out.println();

        System.out.println("예제 출력 1:");
        System.out.println(doc.body().getElementById("sample-output-1").text());

    }
}
