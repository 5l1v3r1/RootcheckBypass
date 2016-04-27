package com.example.xposedwechat;



import java.lang.reflect.Field;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.SparseArray;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;


public class wechat implements IXposedHookLoadPackage {
    @Override public void handleLoadPackage(LoadPackageParam loadPackageParam) throws Throwable {

        if (!loadPackageParam.packageName.equals("com.huawei.hrandroidframe"))
            return;
        XposedBridge.log("loaded: " + loadPackageParam.packageName);
        try{
        			findAndHookMethod("com.huawei.hrandroidbase.utils.PublicUtil", loadPackageParam.classLoader, "isExecutable", String.class,
        				new XC_MethodHook(){
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws
                                Throwable {
                            XposedBridge.log(" Hooked method: " +  param.method);
                            XposedBridge.log(" Hooked method: " +  param.args[0]);
                            param.args[0]="/system/fortest";
                        }
                    });
        			
        			findAndHookMethod("com.huawei.hrandroidbase.utils.PublicUtil", loadPackageParam.classLoader, "isRooted2", 
            				new XC_MethodHook(){
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws
                                    Throwable {
                            	
                            }
                            protected void afterHookedMethod(MethodHookParam param) throws
                            Throwable {
                            	param.setResult(false);
                            }
                            
                        });
        			
        			findAndHookMethod("com.huawei.hrandroidbase.utils.PublicUtil", loadPackageParam.classLoader, "isRooted", 
            				new XC_MethodHook(){
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws
                                    Throwable {
                            	
                            }
                            protected void afterHookedMethod(MethodHookParam param) throws
                            Throwable {
                            	param.setResult(false);
                            }
                            
                        });
        			
        			try{
        			findAndHookMethod("com.huawei.hae.mcloud.bundle.midl.MDMBundle.Proxy", loadPackageParam.classLoader, "isRoot", 
            				new XC_MethodHook(){
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws
                                    Throwable {
                            	
                            }
                            protected void afterHookedMethod(MethodHookParam param) throws
                            Throwable {
                            	param.setResult(false);
                            }
                            
                        });
        			}
        			catch(Exception t){
        				XposedBridge.log(" Hooked failed: proxy");
        			}
        			
        			findAndHookMethod("com.huawei.byod.util.SecurityUtil", loadPackageParam.classLoader, "isRooted", 
            				new XC_MethodHook(){
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws
                                    Throwable {
                            	
                            }
                            protected void afterHookedMethod(MethodHookParam param) throws
                            Throwable {
                            	param.setResult(false);
                            }
                            
                        });
        			
        			findAndHookMethod("com.huawei.byod.util.SecurityUtil", loadPackageParam.classLoader, "isRooted1", 
            				new XC_MethodHook(){
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws
                                    Throwable {
                            	
                            }
                            protected void afterHookedMethod(MethodHookParam param) throws
                            Throwable {
                            	param.setResult(false);
                            }
                            
                        });
        			
        			
        			findAndHookMethod("com.huawei.hrandroidframe.app.App", loadPackageParam.classLoader, "setRooted", boolean.class,
            				new XC_MethodHook(){
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws
                                    Throwable {
                                XposedBridge.log(" Hooked method: " +  param.method);
                                XposedBridge.log(" Hooked method: " +  param.args[0]);
                                param.args[0]=false;
                            }
                        });
        			
        			findAndHookMethod("com.huawei.svn.sdk.mdm.MDMCheckResult", loadPackageParam.classLoader, "setRoot", boolean.class,
            				new XC_MethodHook(){
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws
                                    Throwable {
                                XposedBridge.log(" Hooked method: " +  param.method);
                                XposedBridge.log(" Hooked method: " +  param.args[0]);
                                param.args[0]=false;
                            }
                        });
        			
        			findAndHookMethod("com.huawei.hae.mcloud.rt.utils.RootUtils", loadPackageParam.classLoader, "setIsCheckDeviceRoot", boolean.class,
            				new XC_MethodHook(){
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws
                                    Throwable {
                                XposedBridge.log(" Hooked method: " +  param.method);
                                XposedBridge.log(" Hooked method: " +  param.args[0]);
                                param.args[0]=false;
                            }
                        });
        			
        }
        catch (Throwable t)
        {
            throw t;
        }
    }
}
