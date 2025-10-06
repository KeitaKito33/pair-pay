package com.example.backend.domain.family;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FamilyTest {

    @Test
    @DisplayName("コンストラクタで渡した値がゲッターで正しく取得できること")
    void constructorAndGettersShouldWorkCorrectly() {
        // given（前提条件）: テスト用のデータ
        String familyId = "test-01";
        String familyName = "test-name";

        // when（操作）: Familyオブジェクトを生成する
        Family family = new Family(familyId, familyName);

        // then（結果）: ゲッターで取得した値が、最初に定義した値と一致することを確認する
        assertThat(family.getFamilyId()).isEqualTo(familyId);
        assertThat(family.getFamilyName()).isEqualTo(familyName);
    }
}