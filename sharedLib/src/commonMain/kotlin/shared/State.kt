package shared

sealed class State<out DataType> {
    data class Data<out DataType>(val data: DataType) : State<DataType>()
    data class Error<out DataType>(val error: Throwable) : State<DataType>()
    class Loading<out DataType> : State<DataType>()
    class Empty<out DataType> : State<DataType>()

    fun isLoading(): Boolean = this is Loading
    fun isSuccess(): Boolean = this is Data
    fun isEmpty(): Boolean = this is Empty
    fun isError(): Boolean = this is Error

    fun dataValue(): DataType? = (this as? Data)?.data

    fun errorValue(): Throwable? = (this as? Error)?.error
}