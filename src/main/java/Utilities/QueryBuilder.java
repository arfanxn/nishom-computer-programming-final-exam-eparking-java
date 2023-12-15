/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author arfanxn
 */
public class QueryBuilder {

    private String tableName;
    private String[] columnNames;
    private StringBuilder qsb; // the qsb stands for query string builder
    private String keyword;
    private int limit;
    private int offset;
    private Map<String, String> orderBys;
    private List<String[]> wheres;
    
    public QueryBuilder () {
        this.orderBys = new HashMap<>();
    }

    public String getTableName() {
        return tableName;
    }

    public QueryBuilder setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public QueryBuilder setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public QueryBuilder setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public QueryBuilder setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public QueryBuilder setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public Map<String, String> getOrderBys() {
        return orderBys;
    }

    public QueryBuilder setOrderBys(Map<String, String> orderBys) {
        this.orderBys = orderBys;
        return this;
    }
    
    public QueryBuilder removeOrderBys() {
        this.orderBys = new HashMap<>();
        return this;
    }
    
    public QueryBuilder addOrderBy(String column, String orderBy) {
        this.orderBys = this.orderBys == null ? new HashMap<>() : this.orderBys;
        this.orderBys.put(column, orderBy);
        return this;
    }
    
    public QueryBuilder setWheres(List<String[]> wheres) {
        this.wheres = wheres;
        return this;
    }

    public QueryBuilder removeWheres() {
        this.wheres = new ArrayList<>();
        return this;
    }
    
    public QueryBuilder addWhere(String column, String operator, String value) {
        String[] where = {column, operator, value};
        this.wheres.add(where);
        return this;
    }
    
    public String getString() {
        return this.qsb.toString();
    }

    public QueryBuilder fillByModel(Interfaces.Model model) {
        this.tableName = model.getTableName();
        this.columnNames = model.getColumnNames();
        return this;
    }

    public QueryBuilder buildSelectQuery() {
        this.qsb = new StringBuilder();
        this.qsb.append("SELECT * FROM");
        this.qsb.append(" ").append(this.getTableName());
        if (this.limit != 0) {
            qsb.append(" LIMIT ").append(Integer.toString(this.limit));
        }
        if (this.offset != 0) {
            this.qsb.append(" OFFSET ").append(Integer.toString(this.offset));
        }
        if (this.orderBys.isEmpty() == false) {
            this.qsb.append(" ORDER BY ");
            int index = 0;
            for (Map.Entry<String, String> set : this.orderBys.entrySet()) {
                String column = set.getKey();
                String orderBy = set.getValue();
                if (index > 0) {
                    this.qsb.append(", ");
                }
                this.qsb.append(column).append(" ").append(orderBy);
                index++;
            }
        }
        return this;
    }

    public QueryBuilder buildInsertQuery(int totalRowsToBeInserted) {
        this.qsb = new StringBuilder();
        this.qsb.append("INSERT INTO");
        this.qsb.append(" ").append(this.getTableName());
        for (int i = 0; i < this.getColumnNames().length; i++) {
            if (i == 0) {
                this.qsb.append(" ").append("(");
            }
            this.qsb.append(this.getColumnNames()[i]);
            if ((i + 1) < this.getColumnNames().length) {
                this.qsb.append(", ");
            } else {
                this.qsb.append(")");
            }
        }
        this.qsb.append(" ").append("VALUES");
        for (int i = 0; i < totalRowsToBeInserted; i++) {
            for (int j = 0; j < this.getColumnNames().length; j++) {
                if (j == 0) {
                    this.qsb.append(" ").append("(");
                }
                this.qsb.append("?");
                if ((j + 1) < this.getColumnNames().length) {
                    this.qsb.append(", ");
                } else {
                    this.qsb.append(")");
                }
            }
            if ((i + 1) < totalRowsToBeInserted) {
                this.qsb.append(",");
            } else {
                this.qsb.append(";");
            }
        }

        return this;
    }
    
}
