package com.example.interviewmanager.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.io.IOException;

/**
 * 从相机获取图片数据
 */
public class ReceiveImageFromCameraUtil {
    private Uri imageUri;
    private Context context;

    public ReceiveImageFromCameraUtil(Context context) {
         this.context=context;
    }

    public Intent getCameraIntent(){
        String status= Environment.getExternalStorageState();
        if(status.equals(Environment.MEDIA_MOUNTED)){
            //创建File对象，用于存储拍照后的照片
            File outputImage=new File(context.getExternalCacheDir(),"temp_image.jpg");
            try {
                if(outputImage.exists()){
                    outputImage.delete();
                }
                outputImage.createNewFile();
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
                    imageUri= FileProvider.getUriForFile(context,"com.image.fileprovider",outputImage);
                }else{
                    imageUri=Uri.fromFile(outputImage);
                }
                intent.putExtra(MediaStore.Images.Media.ORIENTATION,0);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                return intent;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
