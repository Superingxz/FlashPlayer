package zzuli.edu.cn.lish04;

import java.util.List;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class FlashActivity extends Activity {
    
	FlashView flash;
	Handler handler;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        flash = (FlashView) findViewById(R.id.flash);
        
        // 检测flash插件是否存在
        PackageManager pm = getPackageManager();   
        PackageInfo flashInfo = null;
        
        List<PackageInfo> infoList = pm.getInstalledPackages(PackageManager.GET_SERVICES);
        for (PackageInfo info : infoList) {
            if ("com.adobe.flashplayer".equals(info.packageName)) {
                flashInfo = info;
                break;
            }  
        }
        
        if(null != flashInfo){
        	// flash播放
            flash.setFlashPath("file:///android_asset/caiti.swf");
        	System.out.println("start");
            flash.start();
        } else {
        	Log.i("test", "----------showError-----------");
        	flash.showError();
        }
        
        handler = new Handler();
    }

	@Override
	protected void onPause() {
		if(flash != null){
			flash.pause();
		}
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		if(flash != null){
			flash.stop();
		}
		super.onDestroy();
	}
}