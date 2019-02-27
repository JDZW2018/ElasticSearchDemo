package cn.com.yusys.search.service;

import cn.com.yusys.search.bean.AstTable;
import cn.com.yusys.search.utils.EsPage;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author tianfs
 * @date 2019/2/12
 * @DESC
 */
public interface IAstTableService {

    String addAstTable(AstTable astTable);

    /**
     * 通过ID获取数据
     *
     * @param index  索引，类似数据库
     * @param type   类型，类似表
     * @param id     数据ID
     * @param fields 需要显示的字段，逗号分隔（缺省为全部字段）
     * @return
     */
    Map<String, Object> searchAstTableById(String index, String type, String id, String fields);

    Integer deleteByAssetNo(String id);

    /**
     * 批量写入es
     *
     * @param index       索引
     * @param type        类型
     * @param jsonObjects 数据
     * @return
     */
    List<String> batchAdd(String index, String type, List<JSONObject> jsonObjects);

    /**
     * 重建索引
     *
     * @return
     */
    Boolean rebuild();

    /**
     * 使用分词查询,并分页
     *
     * @param currentPage    当前页
     * @param pageSize       每页显示条数
     * @param fields         需要显示的字段，逗号分隔（缺省为全部字段）
     * @param sortField      排序字段
     * @param matchPhrase    true 使用，短语精准匹配
     * @param highlightField 高亮字段
     * @param matchStr       过滤条件(xxx)
     * @return
     */
    EsPage searchAstTablePage(int currentPage, int pageSize, String fields, String sortField, boolean matchPhrase, String highlightField, String matchStr);

    Boolean deleteAll();

    Boolean addAll();
}
