import http from 'k6/http';

const url = __ENV.url

export default function () {
	  http.get(url, {
		headers: {
		  'Accept': '*',
		},
	  });
}
