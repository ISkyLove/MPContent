package lc.mpcontent.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import lc.mpcontent.IRemoteService;

/**
 * Created by lin on 16-5-25.
 */
public class RemoteService  extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    private class RemoteServiceImpl extends  IRemoteService.Stub{

        @Override
        public int getWebCount() throws RemoteException {
            return 0;
        }
    }
}
