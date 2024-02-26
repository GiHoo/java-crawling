import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CrawlingTemp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String problemNumber = "2468";
        String userBojId = "gupeng_0428";

        // 가져오기
        String prefix = "https://www.acmicpc.net/status?";
        prefix += "problem_id=" + problemNumber;
        prefix += "&";
        prefix += "user_id=" + userBojId;

        System.out.println(prefix);

        try {
            // Jsoup을 사용하여 웹페이지 가져오기
            Document doc = Jsoup.connect(prefix).get();

            // 해당 HTML 부분 선택하기
            Element table = doc.selectFirst("#status-table");

            // 테이블 내부의 첫 번째 행 가져오기
            Element firstRow = table.selectFirst("td.result");

            String result = firstRow.selectFirst("span.result-text").text();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
