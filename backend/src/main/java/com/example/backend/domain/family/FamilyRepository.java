package com.example.backend.domain.family;
import java.util.List;

/**
 * オブジェクトの操作だけを担当するインターフェース。
 * オブジェクトの状態は隠蔽（カプセル化）されており、外部から直接アクセスできない。
 */
public interface FamilyRepository {
    /**
     * すべての家族を取得します。
     *
     * @return すべてのFamilyのリスト
     */
    List<Family> findAll();
}