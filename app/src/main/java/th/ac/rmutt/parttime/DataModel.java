package th.ac.rmutt.parttime;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DataModel implements Serializable {
    public String title,thumbnail,key,content;

    public DataModel(){ }

    public DataModel(String title, String salary, String thumbnail, String key) {
        this.title = title;
        this.content = content;
        this.thumbnail = thumbnail;
        this.key = key;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("title",title);
        result.put("content",content);
        result.put("thumbnail",thumbnail);
        result.put("key",key);
        return result;
    }
}
