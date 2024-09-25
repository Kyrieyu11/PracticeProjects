import request from '@/utils/request'

export function tree(data) {
  return request({
    url: '/getusers',
    method: 'get',
    params: {
      'deptId': data
    }
  })
}
