package com.nha2023.ex97databinding

import android.database.Observable
import androidx.databinding.ObservableField
import java.util.SimpleTimeZone

//MVVM 패턴의 View에서 사용할 데이터(model)을 연결해주는 ViewModel 역할의 클래스 정의
class MyDataViewModel {
    //이미지뷰에서 보여줄 이미지 sourse URL(문자열 경로)
    val img : ObservableField<String> = ObservableField("https://pixabay.com/ko/illustrations/%ec%a3%bc%eb%b0%a9-%ea%b3%a0%ec%96%91%ec%9d%b4-%ea%b7%80%ec%97%ac%ec%9a%b4-%ea%b3%a0%ec%96%91%ec%9d%b4-2801007/")

    //리사이클러뷰가 보여줄 대량의 데이터
    val items : ObservableField<MutableList<String>> = ObservableField(mutableListOf()) //초기값으로 빈 뮤터블리스트를 만든다
}