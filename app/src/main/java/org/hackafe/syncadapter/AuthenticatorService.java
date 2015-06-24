package org.hackafe.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by groupsky on 24.06.15.
 */
public class AuthenticatorService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return new Authenticator(this).getIBinder();
    }
}
