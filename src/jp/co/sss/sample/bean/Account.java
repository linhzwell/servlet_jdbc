package jp.co.sss.sample.bean;

/**
 * ユーザ情報を保存するためのクラス (テキストP384のソースコードと同内容)
 *
 * @author System Sharedtest
 */
public class Account {
    /** 口座ID */
    private int id;

    /** 名前 */
    private String name;

    /** 金額 */
    private int money;

    /**
     * idフィールドのGetter
     *
     * @return 口座ID
     */
    public int getId() {
        return id;
    }

    /**
     * idフィールドのSetter
     *
     * @param id
     *            口座ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * nameフィールドのGetter
     *
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * nameフィールドのSetter
     *
     * @param name
     *            名前
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * moneyフィールドのGetter
     *
     * @return 金額
     */
    public int getMoney() {
        return money;
    }

    /**
     * moneyフィールドのSetter
     *
     * @param money
     *            金額
     */
    public void setMoney(int money) {
        this.money = money;
    }
}
