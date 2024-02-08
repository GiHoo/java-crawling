import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawling {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String url = br.readLine();
        Document doc = Jsoup.connect(url).get();

        try {
            // .html 파일 생성
            File htmlFile = new File("output.html");
            FileWriter fileWriter = new FileWriter(htmlFile);

            // HTML 문서 내용을 파일에 작성
            fileWriter.write(doc.outerHtml());
            fileWriter.close();

            System.out.println("HTML 파일이 성공적으로 생성되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 크롤링한 이 html 파일을 Json 형식으로 담아서 프론트로 전달. 아마 escape 문자나 처리할 것이 있을 것으로 보임
 */
