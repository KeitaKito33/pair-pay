package com.example.backend.domain.family;

public class Family {
    /**
     * --- フィールド ---
     * finalをつけることで、オブジェクトの状態（内部のデータやプロパティ）が変化しない。
     */
    private final String familyId;   // 家族ID
    private final String familyName; // 家族名

    /**
     * --- コンストラクタ ---
     * new Family(...)のようにオブジェクトをインスタンス化する際に、引数として渡した値がフィールドにセットされる。
     */
    public Family(String familyId, String familyName) {
        this.familyId = familyId;
        this.familyName = familyName;
    }

    /**
     * --- ゲッター ---
     */
    public String getFamilyId() {
        return familyId;
    }

    public String getFamilyName() {
        return familyName;
    } 
}
