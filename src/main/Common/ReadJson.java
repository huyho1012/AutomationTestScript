package Common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public String[] readUserInfoFromJSON() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".\\JsonData\\LoginUser.json");
        Object obj = jsonParser.parse(reader);
        JSONObject userObj = (JSONObject)obj;
        JSONArray userInfo = (JSONArray) userObj.get("userInfo");
        String[] arr = new String[userObj.size()];
        for(int i = 0; i< userInfo.size();i++){
            JSONObject users = (JSONObject) userInfo.get(i);
            String username = (String) users.get("username");
            String password = (String) users.get("password");
            arr[i] = username + "," + password;
        }
        return arr;
    }
}
