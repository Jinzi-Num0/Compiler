package bean;

public enum CategoryCode {
    IDENFR("Ident",1),
    CONSTTK("const",2),
    INTCON("IntConst",3),
    STRCON("FormatString",4),
    MAINTK("main",5),
    INTTK("int",6),
    BREAKTK("break",7),
    CONTINUETK("continue",8),
    IFTK("if",9),
    ELSE("else",10),
    NOT("!",11),
    AND("&&",12),
    OR("||",13),
    WHILETK("while",14),
    GETINTTK("getint",15),
    PRINTFTK("printf",16),
    RETURNTK("return",17),
    PLUS("+",18),
    MINU("-",19),
    MULT("*",20),
    DIV("/",21),
    MOD("%",22),
    LSS("<",23),
    LEQ("<=",24),
    GRE(">",25),
    GEQ(">=",26),
    EQL("==",27),
    NEQ("!=",28),
    ASSIGN("=",29),
    SEMICN (";",30),
    COMMA  (",",31),
    LPARENT ("(",32),
    RPARENT (")",33),
    LBRACK("[",34),
    RBRACK("]",35),
    LBRACE("{",36),
    RBRACE("}",37);


    private String ident;
    private int i;

    @Override
    public String toString() {
        return "CategoryCode{" +
                "ident='" + ident + '\'' +
                ", i=" + i +
                '}';
    }

    CategoryCode(String ident, int i) {
        this.ident = ident;
        this.i = i;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
