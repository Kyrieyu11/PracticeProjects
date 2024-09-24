import { login, logout, getInfo } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'

const getDefaultState = () => {
  return {
    token: getToken(), // 从js-cookie中拿到token值，因为vuex在浏览器关闭之后，就不存在了，所有需要使用js-cookie来进行存储token
    name: '',
    userId: 0,
    gender: '',
    position: '',
    deptName: ''
  }
}

const state = getDefaultState()

const mutations = {
  RESET_STATE: (state) => {
    Object.assign(state, getDefaultState())
  },
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_USERID: (state, userId) => {
    state.userId = userId
  },
  SET_GENDER: (state, gender) => {
    state.gender = gender
  },
  SET_POSITION: (state, position) => {
    state.position = position
  },
  SET_DEPTNAME: (state, deptName) => {
    state.deptName = deptName
  }

}

const actions = {
  // user login
  login({ commit }, userInfo) { // {commit为context，及本user.js中的上下文，可以拿到commit调用上面的mutations}
    const { username, password } = userInfo
    return new Promise((resolve, reject) => {
      login({ username: username.trim(), password: password }).then(response => { // 此login开始使用api/user.js开始访问后台数据了
        const data = JSON.parse(response.data)
        commit('SET_TOKEN', data.token)
        setToken(data.token)
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // get user info
  getInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
      getInfo(state.token).then(response => {
        const data = JSON.parse(response.data)
        if (!data) {
          return reject('Verification failed, please Login again.')
        }
        const { name, userId, gender, position, deptId } = data
        console.log(data.deptId)
        commit('SET_NAME', name)
        commit('SET_USERID', userId)
        commit('SET_GENDER', gender)
        commit('SET_POSITION', position)
        switch (deptId) {
          case 100:
            commit('SET_DEPTNAME', 'AdminDept')
            break
          case 101:
            commit('SET_DEPTNAME', 'Dept1')
            break
          case 102:
            commit('SET_DEPTNAME', 'Dept2')
            break
          case 103:
            commit('SET_DEPTNAME', 'Dept3')
            break
        }

        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },
  // user logout
  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        removeToken() // must remove  token  first
        resetRouter()
        commit('RESET_STATE')
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // remove token
  resetToken({ commit }) {
    return new Promise(resolve => {
      removeToken() // must remove  token  first
      commit('RESET_STATE')
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

