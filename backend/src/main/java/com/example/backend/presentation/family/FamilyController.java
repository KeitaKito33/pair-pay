package com.example.backend.presentation.family;

import com.example.backend.application.family.FamilyApplicationService;
import com.example.backend.domain.family.Family;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 家族に関するAPIリクエストを処理するコントローラー
 */
@RestController // このクラスがAPIのエンドポイントですよ
@RequestMapping("/api/families") // ② このクラスのAPIは "/api/families" でアクセスできるよ
public class FamilyController {

    // フィールド（コントローラーに必要なユースケースを定義）
    private final FamilyApplicationService familyApplicationService;

    // コンストラクタ（フィールドで受け取ったユースケースを生成する）
    public FamilyController(FamilyApplicationService familyApplicationService) {
        this.familyApplicationService = familyApplicationService;
    }

    @GetMapping // HTTPのGETメソッドでアクセスできるAPIエンドポイントを定義（URLはクラスの@RequestMappingと組み合わせて決まる。今回の場合は"/api/families"のまま）
    public List<Family> getAllFamilies() {
        return familyApplicationService.findAllFamilies();
    }
}