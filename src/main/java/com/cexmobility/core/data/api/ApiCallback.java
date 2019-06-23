package com.cexmobility.core.data.api;

import com.cexmobility.core.data.GenericResponse;
import com.cexmobility.core.data.Resource;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

import static com.cexmobility.core.data.ApiMessages.GeneralResponseCode.CODE_ERROR;


/**
 * Created by Yeray Rguez on 29/03/2019.
 */
abstract public class ApiCallback<T extends GenericResponse> implements Callback<T> {

    @Override
    public void onResponse(@NotNull Call<T> call,
                           @NotNull Response<T> response) {
        if (response.body() != null)
        {
            T genericResponse = response.body();
            onFinished(Resource.success(genericResponse));
        }
        else
        {
            onFinished(Resource.error(CODE_ERROR, null));
        }
    }

    @Override
    public void onFailure(@NotNull Call<T> call,
                          @NotNull Throwable throwable) {
        Timber.e(throwable);
        onFinished(Resource.error(CODE_ERROR, null));
    }

    abstract protected void onFinished(Resource<T> resource);

}
