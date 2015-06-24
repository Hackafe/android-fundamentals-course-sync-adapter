package org.hackafe.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SyncService extends Service {
    private static SyncAdapter syncAdapter;
    private static final Object syncLock = new Object();

    public SyncService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (syncLock) {
            if (syncAdapter == null) {
                syncAdapter = new SyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return syncAdapter.getSyncAdapterBinder();
    }
}
