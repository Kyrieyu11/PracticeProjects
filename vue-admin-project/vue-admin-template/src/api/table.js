import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/getuseranddept',
    method: 'get',
    params
  })
}
