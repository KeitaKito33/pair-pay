import React, { useState } from 'react'
import axios from 'axios'

function PaymentForm() {
  // 入力フォームの状態を管理するためのstate
  const [userId, setUserId] = useState('user-001'); // 初期値をダミーデータに設定
  const [amount, setAmount] = useState('');
  const [startMonth, setStartMonth] = useState(''); // "2025-09" のような形式で入力

  const handleSubmit = async (event) => {
    event.preventDefault(); // フォームのデフォルトの送信動作を防ぐ

    // 送信するデータを作成
    const requestData = {
      amount: Number(amount), // 数値型に変換
      startMonth: startMonth,
    };

    try {
      // バックエンドのAPIを呼び出す
      const response = await axios.post(
        `/api/users/${userId}/monthly-payments`,
        requestData
      );

      // 成功した場合
      if (response.status === 201) {
        alert('支払情報の追加に成功しました！');
        // 成功したらフォームをクリアする
        setAmount('');
        setStartMonth('');
      }
    } catch (error) {
      // エラーが発生した場合
      console.error('エラーが発生しました:', error);
      alert('エラーが発生しました。詳細はコンソールを確認してください。');
    }
  };

  return (
    <div>
      <h1>月次支払情報 追加フォーム</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>ユーザーID:</label>
          <input
            type="text"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
            required
          />
        </div>
        <div>
          <label>支払金額:</label>
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            required
          />
        </div>
        <div>
          <label>適用開始月 (YYYY-MM):</label>
          <input
            type="text"
            placeholder="例: 2025-09"
            value={startMonth}
            onChange={(e) => setStartMonth(e.target.value)}
            required
          />
        </div>
        <button type="submit">追加する</button>
      </form>
    </div>
  );
}

export default PaymentForm;