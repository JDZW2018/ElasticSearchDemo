package cn.com.yusys.search.service;

import cn.com.yusys.search.bean.AstTable;
import cn.com.yusys.search.utils.ElasticsearchUtils;
import cn.com.yusys.search.utils.EsPage;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tianfs
 * @date 2019/2/12
 * @DESC
 */
@Service
public class AstTableService implements IAstTableService {
    private static final String INDEX = "ast";
    private static final String TYPE = "ast";

    @Override
    public Map<String, Object> searchAstTableById(String index, String type, String id, String fields) {
        Map<String, Object> map = ElasticsearchUtils.searchDataById(index, type, id, fields);
        return map;
    }

    @Override
    public Integer deleteByAssetNo(String assetNo) {

        return ElasticsearchUtils.deleteDataById(INDEX, TYPE, assetNo);
    }

    @Override
    public String addAstTable(AstTable astTable) {
        if(astTable == null){
            return "error";
        }
        String s = JSONObject.toJSONString(astTable);
        JSONObject object = JSONObject.parseObject(s);
        return ElasticsearchUtils.addData(object, INDEX, TYPE, astTable.getAssetNo());
    }

    @Override
    public List<String> batchAdd(String index, String type, List<JSONObject> jsonObjects) {
        List<String> list = new ArrayList<>();
        for (JSONObject object : jsonObjects) {
            String s = ElasticsearchUtils.addData(object, index, type);
            list.add(s);
        }
        return list;
    }

    @Override
    public Boolean rebuild() {
        return null;
    }

    @Override
    public EsPage searchAstTablePage(int currentPage, int pageSize, String fields, String sortField, boolean matchPhrase, String highlightField, String matchStr) {
        StringBuffer queryStr = new StringBuffer();
        queryStr.append("assetNo=" + matchStr);
        queryStr.append(",name=" + matchStr);
        queryStr.append(",nameDesc=" + matchStr);
        queryStr.append(",colName=" + matchStr);
        queryStr.append(",colDesc=" + matchStr);
        queryStr.append(",spaceName=" + matchStr);
        queryStr.append(",spaceDesc=" + matchStr);
        return ElasticsearchUtils.searchDataPage(INDEX, TYPE, currentPage, pageSize, 0, 0, fields, sortField, matchPhrase, highlightField, queryStr.toString());
    }

    @Override
    public Boolean deleteAll() {
        return ElasticsearchUtils.deleteIndex(INDEX);
    }

    @Override
    public Boolean addAll() {
        return null;
    }


}
