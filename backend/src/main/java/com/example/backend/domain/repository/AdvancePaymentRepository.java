package com.example.backend.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.backend.domain.models.advancepayment.AdvancePayment;

public interface AdvancePaymentRepository {
    /**
     * 新しい立替を保存、または既存の立替を更新します。
     *
     * @param advancePayment 保存または更新するTatekaeオブジェクト
     */
    void save(AdvancePayment advancePayment);

    /**
     * 指定された立替番号で立替を検索します。
     *
     * @param advancePaymentNumber 検索する立替の番号
     * @return 見つかった場合はOptionalでラップされたAdvancePayment、見つからない場合は空のOptional
     */
    Optional<AdvancePayment> findById(String advancePaymentNumber);

    /**
     * 指定されたユーザーIDに紐づく、すべての立替を検索します。
     *
     * @param userId 検索するユーザーのID
     * @return 見つかったAdvancePaymentのリスト。見つからない場合は空のリスト
     */
    List<AdvancePayment> findByUserId(String userId);
}
