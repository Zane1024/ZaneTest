package com.example.em.mi.Fragment_1;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

	List<Fragment> fragmentList = new ArrayList<Fragment>();
	public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
		super(fm);
		this.fragmentList = fragmentList;
	}

	@Override
	public Fragment getItem(int position) {
		if (position == 1) {
			return new New_Fragment();
		} else if (position == 2) {
			return new Jindu_Fragment();
		}else if (position==3){
			return new All_Fragment();
		}
		return new Popularity_Fragment();


	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}

}
