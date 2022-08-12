package com.duokanbook.android.framework.services

object Services {
    private val serviceImplClazzMap: MutableMap<Class<out IService>, Class<out IService>> = HashMap()
    private val serviceImplMap: MutableMap<Class<out IService>, IService> = HashMap()
    fun <T : IService> `as`(serviceClazz: Class<T>): T {
        var impl = serviceImplMap[serviceClazz]
        if (impl == null) {
            val implClazz = serviceImplClazzMap[serviceClazz] as Class<T>
            try {
                impl = implClazz.newInstance()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            }
            serviceImplMap[serviceClazz] = impl!!
        }
        return impl as T
    }

    fun <T : IService> register(service: Class<T>, serviceImpl: Class<out T>) {
        serviceImplClazzMap[service] = serviceImpl
    }

    fun <T : IService> register(service: Class<T>, serviceImpl: T) {
        serviceImplMap[service] = serviceImpl
    }

}