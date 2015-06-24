package org.hackafe.syncadapter;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by groupsky on 24.06.15.
 */
public class Authenticator extends AbstractAccountAuthenticator {


    private static final String TAG = "!!!! AUTHENTICATOR";
    private final AccountManager accountManager;

    public Authenticator(Context context) {
        super(context);
        Log.d(TAG, "constructor");

        accountManager = AccountManager.get(context);
    }

    @Override
    public Bundle editProperties(AccountAuthenticatorResponse response,
                                 String accountType) {
        Log.d(TAG, "editProperties: accountType="+accountType+" response="+response);
        return null;
    }

    @Override
    public Bundle addAccount(AccountAuthenticatorResponse response,
                             String accountType,
                             String authTokenType,
                             String[] requiredFeatures,
                             Bundle options) throws NetworkErrorException {
        String requiredFeaturesStr = "";
        if (requiredFeatures != null) {
            for (String r: requiredFeatures){
                requiredFeaturesStr += ", "+r;
            }
            requiredFeaturesStr = "["+requiredFeaturesStr+"]";
        } else {
            requiredFeaturesStr = "null";
        }
        Log.d(TAG, "addAccount: accountType=" + accountType +
                " authTokenType=" + authTokenType +
                " requiredFeatures=" + requiredFeaturesStr +
                " options=" + DebugUtils.toString(options) +
                " response=" + response);

        Account account = new Account("geno", accountType);
        accountManager.addAccountExplicitly(account, null, null);

        Bundle res = new Bundle();
        res.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
        res.putString(AccountManager.KEY_ACCOUNT_TYPE, account.type);

        return res;
    }

    @Override
    public Bundle confirmCredentials(AccountAuthenticatorResponse response,
                                     Account account,
                                     Bundle options) throws NetworkErrorException {
        Log.d(TAG, "confirmCredentials: account="+account+" options="+options+" response="+response);
        return null;
    }

    @Override
    public Bundle getAuthToken(AccountAuthenticatorResponse response,
                               Account account,
                               String authTokenType,
                               Bundle options) throws NetworkErrorException {
        Log.d(TAG, "getAuthToken: account="+account+
                " authTokenType="+authTokenType+
                " options="+options+
                " response="+response);
        return null;
    }

    @Override
    public String getAuthTokenLabel(String authTokenType) {
        Log.d(TAG, "getAuthTokenLabel: authTokenType="+authTokenType);
        return null;
    }

    @Override
    public Bundle updateCredentials(AccountAuthenticatorResponse response,
                                    Account account,
                                    String authTokenType,
                                    Bundle options) throws NetworkErrorException {
        Log.d(TAG, "updateCredentials: account="+account+
                " authTokenType="+authTokenType+
                " options="+options+
                " response="+response);
        return null;
    }

    @Override
    public Bundle hasFeatures(AccountAuthenticatorResponse response,
                              Account account,
                              String[] features) throws NetworkErrorException {
        String featuresStr = "";
        if (features != null) {
            for (String r: features){
                featuresStr += ", "+r;
            }
            featuresStr = "["+featuresStr+"]";
        } else {
            featuresStr = "null";
        }
        Log.d(TAG, "hasFeatures: account="+account+
                " feature="+featuresStr+
                " response="+response);
        return null;
    }
}
