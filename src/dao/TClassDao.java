package dao;

import entity.TClass.*;
import java.util.*;

public interface TClassDao {
    public int updateTClass(String sql, Object[] param);

    public List<TClass> selectTClass(String sql, Object[] param);
}
