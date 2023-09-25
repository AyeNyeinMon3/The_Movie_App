//package com.example.themovieapp.network.dataagents
//
//import com.example.movie.network.responses.GenreListResponse
//import com.example.themovieapp.data.vos.CastVO
//import com.example.themovieapp.data.vos.GenreVO
//import com.example.themovieapp.data.vos.MovieVO
//import com.example.themovieapp.data.vos.VideoVO
//import com.example.themovieapp.network.TheMovieApi
//import com.example.themovieapp.network.responses.CreditMovieResponse
//import com.example.themovieapp.network.responses.MovieListResponse
//import com.example.themovieapp.utils.BASE_URL
//import okhttp3.OkHttpClient
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.create
//import java.util.concurrent.TimeUnit
//
//object RetrofitDataAgentImpl:MovieDataAgent {
//
//    private var mTheMovieApi : TheMovieApi? = null
//
//    init {
//        val okHttpClient = OkHttpClient.Builder()
//            .connectTimeout(15,TimeUnit.SECONDS)
//            .readTimeout(15,TimeUnit.SECONDS)
//            .writeTimeout(15,TimeUnit.SECONDS)
//            .build()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        mTheMovieApi = retrofit.create(TheMovieApi::class.java)
//
//    }
//
//
//
//
//    override fun getNowPlaying(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
//
//        mTheMovieApi?.getNowPlaying()
//            ?.enqueue(object : Callback<MovieListResponse>{
//                override fun onResponse(
//                    call: Call<MovieListResponse>,
//                    response: Response<MovieListResponse>
//                ) {
//                    if (response.isSuccessful){
//
//                        onSuccess(response.body()?.result ?: listOf() )
//                    }else{
//                        onFailure(response.message())
//                    }
//
//                }
//
//                override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
//                        onFailure(t.message ?: "")
//                }
//
//            })
//
//    }
//
//    override fun getMovieDetails(
//        movieId: String,
//        onSuccess: (MovieVO) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//
//        mTheMovieApi?.getMovieDetails(movieId)
//            ?.enqueue(object  : Callback<MovieVO>{
//                override fun onResponse(call: Call<MovieVO>, response: Response<MovieVO>) {
//                    if (response.isSuccessful){
//                       response.body()?.let {
//                           onSuccess(it)
//                       }
//                    }else
//                        onFailure(response.message())
//                }
//
//                override fun onFailure(call: Call<MovieVO>, t: Throwable) {
//
//                    onFailure(t.message ?: "")
//
//                }
//
//            })
//
//    }
//
//    override fun getVideos(
//        movieId: String,
//        onSuccess: (VideoVO) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//        mTheMovieApi?.getVideos(movieId)
//            ?.enqueue(object : Callback<VideoVO>{
//                override fun onResponse(call: Call<VideoVO>, response: Response<VideoVO>) {
//                    if (response.isSuccessful){
//                        response.body()?.let{
//                            onSuccess(it)
//                        }
//                    }
//                    else{
//                        onFailure(response.message())
//                    }
//                }
//
//                override fun onFailure(call: Call<VideoVO>, t: Throwable) {
//
//                    onFailure(t.message ?: "")
//
//                }
//
//            })
//    }
//
//    override fun getGenreList(onSuccess: (List<GenreVO>) -> Unit, onFailure: (String) -> Unit) {
//        mTheMovieApi?.getGenreList()
//            ?.enqueue(object : Callback<GenreListResponse>{
//                override fun onResponse(
//                    call: Call<GenreListResponse>,
//                    response: Response<GenreListResponse>
//                ) {
//                    if (response.isSuccessful){
//                        onSuccess(response.body()?.genres ?: listOf())
//                    }
//                    else
//                        onFailure(response.message())
//                }
//
//                override fun onFailure(call: Call<GenreListResponse>, t: Throwable) {
//                    onFailure(t.message ?: "")
//                }
//
//            })
//    }
//
//    override fun getMoviesByGenre(
//        genreId: String,
//        onSuccess: (List<MovieVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//
//        mTheMovieApi?.getMoviesByGenre(genreId)
//            ?.enqueue(object : Callback<MovieListResponse>{
//                override fun onResponse(
//                    call: Call<MovieListResponse>,
//                    response: Response<MovieListResponse>
//                ) {
//                    if (response.isSuccessful){
//                        onSuccess(response.body()?.result ?: listOf())
//                    }else{
//                        onFailure(response.message())
//                    }
//                }
//
//                override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
//                    onFailure(t.message ?: "")
//                }
//
//            })
//
//    }
//
//    override fun getActors(
//        movieId: String,
//        onSuccess: (List<CastVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//        mTheMovieApi?.getActors(movieId)
//            ?.enqueue(object : Callback<CreditMovieResponse>{
//                override fun onResponse(
//                    call: Call<CreditMovieResponse>,
//                    response: Response<CreditMovieResponse>
//                ) {
//
//                    if (response.isSuccessful){
//                        onSuccess(response.body()?.cast ?: listOf())
//                    }
//                    else
//                        onFailure(response.message())
//
//                }
//
//                override fun onFailure(call: Call<CreditMovieResponse>, t: Throwable) {
//
//                    onFailure(t.message ?: "")
//
//                }
//
//            })
//    }
//
//    override fun getSearchMovies(
//        query: String,
//        onSuccess: (List<MovieVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//        mTheMovieApi?.getSearchMovies(query = query)
//            ?.enqueue(object : Callback<MovieListResponse>{
//                override fun onResponse(
//                    call: Call<MovieListResponse>,
//                    response: Response<MovieListResponse>
//                ) {
//                    if (response.isSuccessful){
//                        onSuccess(response.body()?.result ?: listOf())
//                    }else
//                        onFailure(response.message())
//                }
//
//                override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
//                    onFailure(t.message ?: "")
//                }
//
//            })
//    }
//}