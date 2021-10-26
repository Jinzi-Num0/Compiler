package Services.Impl;

import Dao.BaseCatCode;
import Dao.Impl.CatCodeImpl;
import Services.BaseCatCodeServ;

public class CatCodeServImpl implements BaseCatCodeServ {

    //将Dao中的实现类定义出来
    public static BaseCatCode CatCodeDao = new CatCodeImpl();

    /**
     * 判断是哪一种类别码
     * @param word 传入一个单词
     * @return 如果是保留字则直接返回IDENFR，如果是保留字 则返回一个String类型的保留字名称
     */
    @Override
    public String isCatCodeServ(StringBuffer word) {
        return CatCodeDao.isCatCode(word);
    }
}
