package cn.com.yusys.search.controller;

import cn.com.yusys.search.bean.AstTable;
import cn.com.yusys.search.service.IAstTableService;
import cn.com.yusys.search.utils.EsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author tianfusheng
 * @date 2019/2/12
 * @DESC
 */
@RestController
@RequestMapping("/api/es/astTable")
public class AstTableController {

    @Autowired
    private IAstTableService service;

    @GetMapping("/searchDataById")
    public Map<String, Object> searchDataById(String id) {
        return service.searchAstTableById("ast", "ast", id, null);
    }

    @PostMapping("/add")
    public String add( AstTable astTable) {
        return service.addAstTable(astTable);
    }

    @PostMapping("/del/{id}")
    public String del(@PathVariable("id") String id){
        Integer status =  service.deleteByAssetNo(id);
        return HttpServletResponse.SC_OK == status?"success":"error";
    }

    @GetMapping("/query")
    public EsPage query(@RequestParam("begin") int begin, @RequestParam("size") int size, @RequestParam(name = "sortField",required = false) String sortField, @RequestParam("matchStr") String matchStr){
       return service.searchAstTablePage(begin,size,null,sortField,false,null,matchStr);
    }
    @PostMapping("/deleteAll")
    public Boolean deleteAll(){
        return service.deleteAll();
    }

    @PostMapping("/addAll")
    public Boolean addAll(){
        return service.addAll();
    }

}
