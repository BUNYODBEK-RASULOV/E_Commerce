package database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public interface DataBase<T> {

    ObjectMapper objectMapper = new ObjectMapper();
    default List<T> readList(String className){
        try {
            ArrayList<T> list = objectMapper.readValue(new File("main/resources/"+className+".json"), new TypeReference<ArrayList<T>>() {
            });
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {

        }
    }



    default String writeList(List<T> list) throws Exception {
        File file = new File("D:\\text.json");
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            Gson gson = new Gson();
            for (T t : list) {
                String jsonText = gson.toJson(t);
                writer.write(jsonText);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();

        }


        return "SUCCESS";
    }

}
