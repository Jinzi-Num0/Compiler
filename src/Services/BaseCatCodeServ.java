package Services;

public interface BaseCatCodeServ {
    /**
     * 判断是哪一种类别码
     * @param word 传入一个单词
     * @return 如果是保留字则直接返回IDENFR，如果是保留字 则返回一个String类型的保留字名称
     */
    public String isCatCodeServ(StringBuffer word);
}
