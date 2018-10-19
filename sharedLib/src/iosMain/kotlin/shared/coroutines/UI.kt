package shared.coroutines

import kotlin.coroutines.CoroutineContext

internal actual val UI: CoroutineContext = MainQueueCoroutineDispatcher()