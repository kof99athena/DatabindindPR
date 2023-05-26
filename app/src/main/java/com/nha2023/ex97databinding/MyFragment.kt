package com.nha2023.ex97databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nha2023.ex97databinding.databinding.FragmentMyBinding

class MyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my,container,false)
        return binding.root //뷰그룹 : 우리로따지면 LinearLayout
    }
    lateinit var binding : FragmentMyBinding //언제 초기화하냐? onCreateView가 생길때

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //xml 레이아웃에서 사용할 데이터 클래스 객체 생성 및 설정
        binding.vm = MyDataViewModel()

    }
}