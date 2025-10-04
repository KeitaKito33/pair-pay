package com.example.backend.application.family;

import com.example.backend.domain.family.Family;
import com.example.backend.domain.family.FamilyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 家族に関するユースケースを実現するアプリケーションサービス
 */
@Service // このクラスがサービス部品ですよ
public class FamilyApplicationService {

    /**
     * --- フィールド ---
     * モノがどんな情報を持っているかを定義
     * ユースケース層では、ユースケースに必要な部品を定義するイメージ
     */
    private final FamilyRepository familyRepository;

    /**
     * --- コンストラクタ ---
     * モノに必要な情報をすべて受け取って、正しい状態で誕生させる
     * ユースケース層では、フィールドで受け取った部品を誕生させる
     */
    public FamilyApplicationService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    /**
     * すべての家族情報を取得する
     */
    public List<Family> findAllFamilies() {
        // ドメイン層のリポジトリに処理を依頼し、結果をそのまま返す
        return familyRepository.findAll();
    }
}