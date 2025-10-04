package com.example.backend.infrastructure.family;

import com.example.backend.domain.family.Family;
import com.example.backend.domain.family.FamilyRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * InMemoryはDBを使用せず、メモリ上にデータを保存する（DBを使用するものは、「Jpa」を冒頭に付ける）
 * インターフェースはメソッドを定義するクラスの設計書のようなものであり、実際の処理は実装クラス（implements）で行う
 */
@Repository // このクラスが永続化データ（DBに保存されるデータ）を扱う部品ですよ
public class InMemoryFamilyRepository implements FamilyRepository {

    /**
     * メモリ上にデータを保存するための箱（store）を用意する
     * Mapはキーと値のペアでデータを保存するデータ構造（Map<キーの型, 値の型>）
     * HashMapはMapを使うときのお作法で、同時書き込みが考えられる場合はConcurrentHashMapを使う（ConcurrentHashMapを通常利用するデメリットは小さいと判断したため、今回はこちらを使用）
     */
    private final Map<String, Family> store = new ConcurrentHashMap<>();

    /**
     * コンストラクタ
     * オブジェクトやフィールドの初期化
     */
    public InMemoryFamilyRepository() {
        // ダミーデータの作成
        Family family1 = new Family("01", "けいた");
        Family family2 = new Family("02", "みずほ");

        // storeにダミーデータを保存
        store.put(family1.getFamilyId(), family1);
        store.put(family2.getFamilyId(), family2);
    }

    @Override   // インターフェースで定義された「findall()メソッド」を上書きしますよ
    public List<Family> findAll() {
        // ④ Mapに保存されているすべてのFamilyオブジェクトをリストにして返す
        return new ArrayList<>(store.values());
    }
}