package springoraclesql.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springoraclesql.demo.service.SqlService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private SqlService sqlService;

    @Autowired
    public IndexController(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    @GetMapping("/")
    public String index(Model model){
        try(Connection connection = sqlService.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from book");
//            rs.next();
            List<String> list = listResultSet(rs);
            model.addAttribute("resultSet", list);
            System.out.println(list.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "index";
    }

    private static ArrayList<String> listResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData meta = resultSet.getMetaData();
        int columns = meta.getColumnCount();
        ArrayList<String> list = new ArrayList<>();
        while(resultSet.next()){
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<=columns; i++){
                sb.append(meta.getColumnName(i)+":"+resultSet.getString(i)+"  ;  ");
            }
            list.add(sb.toString());
        }
        return list;
    }

}
