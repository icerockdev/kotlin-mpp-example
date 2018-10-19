package shared.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal actual val UI: CoroutineContext = Dispatchers.Main
