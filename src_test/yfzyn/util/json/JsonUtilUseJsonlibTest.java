package yfzyn.util.json;

import org.junit.Test;
import yfzyn.entity.json.Address;
import yfzyn.entity.json.Person;
import yfzyn.entity.json.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoliu (yfzyn) on 12/1/2016.
 */
public class JsonUtilUseJsonlibTest {

    private static final String JSON_STR_2_MAP = "{\n" +
            "  \"man\":{\n" +
            "    \"personName\":\"xiao\",\n" +
            "    \"personAlive\":\"true\",\n" +
            "    \"personsPets\":[\n" +
            "      {\"petName\":\"Anna\",\"petAge\":12},\n" +
            "      {\"petName\":\"Jose\",\"petAge\":16}\n" +
            "    ],\n" +
            "    \"personsAddress\":{\n" +
            "      \"addressIp\":\"wuhan\",\"addressNumber\":01\n" +
            "    }\n" +
            "  },\n" +
            "  \"address\":{\n" +
            "  \t\"addressIp\":\"shanghai\",\n" +
            "    \"addressNumber\":02\n" +
            "  },\n" +
            "  \"pet\":{\n" +
            "  \t\"petName\":\"Time\",\n" +
            "    \"petAge\":22\n" +
            "  }\n" +
            "}";

    private static final String JSON_STR_2_JAVA_OBJECT = "{\n" +
            "    \"personName\":\"xiao\",\n" +
            "    \"personAlive\":\"true\",\n" +
            "    \"personsPets\":[\n" +
            "      {\"petName\":\"Anna\",\"petAge\":12},\n" +
            "      {\"petName\":\"Jose\",\"petAge\":16}\n" +
            "    ],\n" +
            "    \"personsAddress\":{\n" +
            "      \"addressIp\":\"wuhan\",\"addressNumber\":01\n" +
            "    }\n" +
            "  }";
    @Test
    public void testJsonStr2Map(){
        Map<String, Class> classMap = new HashMap<>();
        classMap.put("man", Person.class);
        classMap.put("personsAddress",Address.class);
        classMap.put("personsPets",Pet.class);
        classMap.put("address", Address.class);
        classMap.put("pet", Pet.class);

        Map<String, Object> objectMap = JsonUtilUseJsonlib.jsonStr2Map(JSON_STR_2_MAP,classMap);
        System.out.println(objectMap);

        Person person = (Person) objectMap.get("man");
        Address address = (Address)objectMap.get("address");
        Pet pet = (Pet)objectMap.get("pet");
        System.out.println(person);
        System.out.println(address);
        System.out.println(pet);
    }

    @Test
    public void testJsonStr2JaveObject(){
        Map<String, Class> classMap = new HashMap<>();
        classMap.put("personsPets", Pet.class);
        classMap.put("personsAddress", Address.class);

        Person person = (Person) JsonUtilUseJsonlib.jsonStr2JaveObject(JSON_STR_2_JAVA_OBJECT, Person.class, classMap);
        System.out.println(person);
    }

    @Test
    public void testJavaObject2JsonStr(){
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet("Living", 9));
        pets.add(new Pet("Going", 3));
        Person person = new Person("xiao", true, pets, null);
        String jsonStr = JsonUtilUseJsonlib.javaObject2JsonStr(person);
        System.out.println(jsonStr);
    }
}
