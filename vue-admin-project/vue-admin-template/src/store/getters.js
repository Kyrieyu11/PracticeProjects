const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  token: state => state.user.token,
  name: state => state.user.name,
  userId: state => state.user.userId,
  gender: state => state.user.gender,
  position: state => state.user.position,
  deptName: state => state.user.deptName
}
export default getters
