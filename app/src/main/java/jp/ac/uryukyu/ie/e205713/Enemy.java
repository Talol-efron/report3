package jp.ac.uryukyu.ie.e205713;


/**
 * 敵クラス。 String name; //敵の名前 int hitPoint; //敵のHP int attack; //敵の攻撃力 boolean
 * dead; //敵の生死状態。true=死亡。 Created by tnal on 2016/11/13.
 */
public class Enemy {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    

    //メソッド名の最初の３文字は「get」する
    //例外としてboolean型の場合のみisXxxx()と言うメソッド名にする。

    /**
     * getterメソッドを用意し,private指定したnameにアクセス可能にする
     * @return String型 name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * getterメソッドを用意し,private指定したhitpointにアクセス可能にする
     * 
     * @return int型 hitpoint
     */
    public int getHitpoint(){
        return this.hitPoint;
    }
    
    /**
     * getterメソッドを用意し,private指定したattackにアクセス可能にする
     * 
     * @return int型 attack
     */
    public int getAttack(){
        return this.attack;
    }
    
    /**
     * getterメソッドを用意し,private指定したdeadにアクセス可能にする
     * 
     * @return boolean型 dead
     */
    public boolean isDead(){
        return this.dead;
    }


    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * 
     * @param name      モンスター名
     * @param maximumHP モンスターのHP
     * @param attack    モンスターの攻撃力
     */
    public Enemy(String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。 attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * 
     * @param hero 攻撃対象
     */
    public void attack(Hero hero) {
        if (hitPoint > 0){
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.name, damage);
            hero.wounded(damage);
        }
        

    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * 
     * @param damage 受けたダメージ
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}
