import request from '@/utils/request'

export function translate(data) {
  return request({
    url: '/translate',
    method: 'post',
    params: {
      'q': data.q,
      'from': data.from,
      'to': data.to
    }
  })
}
